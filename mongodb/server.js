const express = require('express');
const app = express();

const users = [];

app.get("/user", function(req, res) {
    return res.send({users: users})
})

app.post("/user", function(req, res) {
    users.push({name:"bear", age:30})
    return res.send({success: true})
})

app.listen(3000, function() {
    console.log('server listening on port 3000')
})