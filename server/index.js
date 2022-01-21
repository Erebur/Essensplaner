// server/index.js

const express = require("express");
const bodyParser = require("body-parser");
const router = express.Router();
const app = express();
const sqlite3 = require("sqlite3");
const crypto = require("crypto");

const PORT = process.env.PORT || 3001;
const apikey = 42069;
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
			`INSERT INTO users(user_name,user_group, user_password) 
		Values (?,?,?)`,
			[req.body["name"], req.body["group"], req.body["password"]]
		);
	});
	//TODO shopping list get
	/**
	 * needs your authentication token and a Produkt name to search
	 */
	app.get("/api/shoppinglist/get", (req, res) => {
		console.log(req);
		if (true) {
			db.each(
				"Select * from shoppinglist Where user_group = ? and product_name = ?",
				//TODO 
				[req.body["GroupID"], req.body["product_name"]],
				(err, row) => {
					if (err) console.log(err);
					res.json({ name: row.product_name, Amount: row.product_amount });
				}
			);
		}
	});

	//TODO shopping list post
	app.post("/api/shoppinglist/post", (req, res) => {
		console.log(req);
		if (true) {
			db.each(
				"Insert into shoppinglist (user_group ,product_name , product_amount) Values (?) ",
				[
					req.body["GroupID"],
					req.body["product_name"],
					req.body["product_amount"],
				]
			);
		}
	});

	// {
	// 	"apikey": "42069",
	// 	"GroupID": 10,
	// 	"product_name": "Menschen",
	// 	"product_amount": 10
		  
	// }

	app.listen(PORT, () => {
		console.log(`Server listening on ${PORT}`);
	});
}

class user {
	constructor(name, group) {
		this.name = name;
		this.group = group;
	}
}
