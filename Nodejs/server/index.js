const mysql = require('mysql');
const express = require('express');
const config = require('config');
const cors = require('cors');
const users = require('./routes/users');

const PORT = config.get("port");

const app = express(); 
app.use(express.json());
app.use(cors());
app.use('/users', users);

app.listen(PORT, () => {console.log(`Server started listening at PORT ${PORT}`)});