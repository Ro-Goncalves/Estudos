const express = require("express");
const bodyParser = require("body-parser");
const jwt = require("jsonwebtoken");

const app = express();
const secretKey = "yourSecretKey"

app.use(bodyParser.json())

app.post("/login", (req, res) => {
    const { username, password} = req.body;

    if(username == "admin" && password === "admin"){
        const token = jwt.sign({username}, secretKey, {expiresIn: "1h"});
        res.json({token})
    }else{
        res.status(401).json({error: "Authentication failed"})
    }
});

app.get("/protected", verifyToken, (req, res) => {
    res.json({message: "Protected route accessed successfully"});
});

function verifyToken(req, res, next){
    const token = req.headers["authorization"];
    console.log(token);
    if(!token){
        return res.status(403).json({error: "Token not provided"});
    }

    jwt.verify(token, secretKey, (err, decoded) => {
        console.log(err);
        if(err){
            return res.status(401).json({error: "Failed to authentication toke"});
        }

        req.user = decoded;
        next();
    });
}

const port = 8000;
app.listen(port, () => {
    console.log(`Server is running on ${port}`);
})