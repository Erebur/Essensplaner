// server/index.js

const express = require("express");
const bodyParser = require("body-parser");
const router = express.Router();
const app = express();
const sqlite3 = require("sqlite3");
const crypto = require("crypto");

const PORT = process.env.PORT || 3001;

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
					loggedInUsers[UUID] = {
						name: row.user_name,
						email: row.user_email,
						group: row.user_group,
					};
					state = true;
				}
				response.json({
					name: row.name,
					email: row.email,
					state: state,
					UUID: UUID,
				});
			}
		);
	});
	//TODO create user post
	app.post("/api/create_user", (req, res) => {
		db.each();
	});
	//TODO shopping list get
	app.get("/api/shoppinglist", (req, res) => {
		console.log(req.body);
		if (loggedInUsers.includes(req.body.key)) {
			db.each("Select * from shoppinglist Where user_ ");
		}
	});

	app.listen(PORT, () => {
		console.log(`Server listening on ${PORT}`);
	});
}
