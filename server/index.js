// server/index.js

const express = require("express");
const bodyParser = require("body-parser");
const router = express.Router();
const app = express();
const sqlite3 = require('sqlite');

const PORT = process.env.PORT || 3001;
app.use("/", router);

let test = "Help";


app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

router.get('/',(req,res) => {
    res.sendfile("index.html");
});

app.post("/api/login" , (req,res) =>{
})


app.get("/api/did" , (req,res) =>{
    if (req)
    res.json({message:test})
    console.log(res)
})

app.post("/api/put",(req , res)=>{
    console.log(req.body)
    res.json({message:"hello"})
})

app.listen(PORT, () => {
    console.log(`Server listening on ${PORT}`);
});
