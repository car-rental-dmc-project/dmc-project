const mysql = require('mysql2');
const express = require('express');
const config = require('config');
const cors = require('cors');
const users = require('./routes/users');
const car_details = require('./routes/car_details');

const PORT = config.get("port");

const app = express(); 
app.use(express.json());
app.use(cors());
app.use('/users', users);
app.use('/cars', car_details);

app.listen(PORT, () => {console.log(`Server started listening at PORT ${PORT}`)});