const express = require('express');
const app = express();
const mongoose = require('mongoose');

const users = [];

const MONGO_URI = 'mongodb+srv://admin:6Zwhm25KTEOkEj5U@tutorial.gwxhv.mongodb.net/BlogService?retryWrites=true&w=majority';

const server = async() => {
    try {
        await mongoose.connect(MONGO_URI, { useNewUrlParser: true, useUnifiedTopology: true });
        console.log('MongoDB connected')
    
        app.use(express.json())
    
        app.get("/user", function(req, res) {
            return res.send({users: users})
        })
    
        app.post("/user", function(req, res) {
            console.log(req.body)
            users.push({ name:req.body.name, age:req.body.age })
            return res.send({success: true})
        })
    
        app.listen(3000, function() {
            console.log('server listening on port 3000');
        })
    } catch(err) {
        console.log(err)
    }
}

server();