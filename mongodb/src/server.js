const express = require('express');
const app = express();
const mongoose = require('mongoose');
const { userRouter } = require('./routes/userRoute')

const MONGO_URI = 'mongodb+srv://yjjung:@inflean-mongodb.gwxhv.mongodb.net/BlogService?retryWrites=true&w=majority';

const server = async() => {
    try {
        await mongoose.connect(MONGO_URI, { useNewUrlParser: true, useUnifiedTopology: true, useCreateIndex: true, useFindAndModify:false });
        mongoose.set('debug', true)
        console.log('MongoDB connected')
        app.use(express.json())
        
        app.use('/user', userRouter)

        app.listen(3000, () => console.log('server listening on port 3000'))
    } catch(err) {
        console.log(err)
    }
}

server();