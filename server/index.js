// server/index.js

const express = require("express");
const bodyParser = require("body-parser");
const router = express.Router();
const app = express();
const sqlite3 = require("sqlite3");
const crypto = require("crypto");

const PORT = process.env.PORT || 3001;
const api_key = 42069;
const loggedInUsers = {};

let db = DB();

API();

function DB() {
	return new sqlite3.Database("db/SQLite.db", (err) => {
		if (err) {
			console.error(err.message);
		} else {
			console.log("Connected to the database.");
		}
	});
}

function API() {
	app.use("/", router);
	app.use(bodyParser.urlencoded({ extended: false }));
	app.use(bodyParser.json());

	router.get("/", (req, res) => {
		res.sendfile("index.html");
	});

	app.listen(PORT, () => {
		console.log(`Server listening on ${PORT}`);
	});

	//#region authentication
	app.post("/api/login", (req, response) => {
		db.each(
			`Select user_name , user_email , user_password from users WHERE user_name = ? OR user_email = ?`,
			[req.body["username"]],
			(err, row) => {
				if (err) throw err;
				console.log(
					`request from ${row.user_name}|${row.user_email}|with ${
						req.body["username"]
					},${req.body["password"]},${
						req.body["password"] == row.user_password
					}`
				);

				var UUID;
				var state = false;
				if (req.body["password"] == row.user_password) {
					//TODO extract login to fun
					UUID = crypto.randomUUID();
					loggedInUsers[UUID] = new user(row.user_name, row.user_group);
					state = true;
				}
				response.json({
					name: row.name,
					state: state,
					UUID: UUID,
				});
			}
		);
	});

	//TODO create user post
	app.post("/api/create_user", (req, res) => {
		db.each(
			`INSERT INTO users(user_name,user_group, user_password) Values (?,?,?)`,
			[req.body["name"], req.body["group"], req.body["password"]]
		);
	});

	//#endregion

	//#region Shopping list
	/**
	 * needs your authentication token and a Product name to search
	 */
	app.post("/api/shopping_list/get", (req, res) => {
		console.log(req.body);
		if (req.body["api_key"] != api_key) {
			return;
		}
		db.each(
			"Select * from shopping_list Where user_group = ? and product_name = ?",
			[req.body["group_id"], req.body["product_name"]],
			(err, row) => {
				if (err) console.log(err);
				res.json({ name: row.product_name, amount: row.product_amount });
			}
		);
	});
	// TODO fix this
	app.post("/api/shopping_list/get_all", (req, res) => {
		console.log(req.body);
		if (req.body["api_key"] != api_key) {
			return;
		}
		let json ;
		db.each(
			"Select * from shopping_list Where user_group = ?",
			[req.body["group_id"]],
			(err, row) => {
				if (err) console.log(err);
				json += `"${row.product_name}" :` + JSON.stringify({amount : row.product_amount })
			}
		);
		res.json(json);
	});

	app.post("/api/shopping_list/post", (req, res) => {
		console.log(req.body);
		if (req.body["api_key"] != api_key) {
			return;
		}
		db.each(
			"Insert into shopping_list (user_group ,product_name , product_amount) Values (?, ? , ?) ",
			[
				req.body["group_id"],
				req.body["product_name"],
				req.body["product_amount"],
			],
			(err, row) => {
				if (err) console.log(err);
				res.status(502).send();
			}
			//how tf does this work
		);
	});
	// #endregion

	// {
	// 	"apikey": "42069",
	// 	"group_id": 10,
	// 	"product_name": "Menschen",
	// 	"product_amount": 10
	// }
}

// class user {
// 	constructor(name, group) {
// 		this.name = name;
// 		this.group = group;
// 	}
// }
