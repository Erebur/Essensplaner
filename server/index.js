// server/index.js

const express = require("express");
const bodyParser = require("body-parser");
const router = express.Router();
const app = express();
const sqlite3 = require('sqlite3');

const PORT = process.env.PORT || 3001;


let test = "Help";

let db = DB();

API();

function DB() {
    return new sqlite3.Database('db/login.db', (err) => {
        if (err) {
            console.error(err.message);
        } else {
            console.log('Connected to the database.');
        }
    });
}

function API() {

    app.use("/", router);
    app.use(bodyParser.urlencoded({ extended: false }));
    app.use(bodyParser.json())

    router.get('/', (req, res) => {
        res.sendfile("index.html");
    });

    app.post("/api/login", (req, res) => {
    });


    app.get("/api/did", (req, res) => {
        if (req)
            res.json({ message: test });
        console.log(res);
    });

    app.post("/api/put", (req, res) => {
        console.log(req.body);
        res.json({ message: "hello" });
    });

    app.listen(PORT, () => {
        console.log(`Server listening on ${PORT}`);
    });
}

