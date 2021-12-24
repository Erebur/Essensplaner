// server/index.js

const express = require("express");
const bodyParser = require("body-parser");
const router = express.Router();
const app = express();
const sqlite3 = require("sqlite3");
const crypto = require("crypto");

const PORT = process.env.PORT || 3001;

const loggedInUsers = [];

let test = "Help";

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
			`Select name , email , password 
                    from login 
                    WHERE name = ?
                    OR email = ?`,
			[req.body["username"]],
			(err, row) => {
				if (err) throw err;
				console.log(
					`request from ${row.name}|${row.email}|with ${req.body["username"]},${
						req.body["password"]
					},${req.body["password"] == row.password}`
				);

				var UUID;
				if (req.body["password"] == row.password) {
					UUID = crypto.randomUUID();
					loggedInUsers.push(UUID);
				}
				response.json({ name: row.name, email: row.email, UUID: UUID });
			}
		);
	});

	// app.get("/api/did", (req, res) => {
	//     if (req)
	//         res.json({ message: test });
	//     console.log(res);
	// });

	app.post("/api/put", (req, res) => {
		console.log(req.body);
		res.json({ message: "hello" });
	});

	app.listen(PORT, () => {
		console.log(`Server listening on ${PORT}`);
	});
}
