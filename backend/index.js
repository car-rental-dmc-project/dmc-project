const mysql = require('mysql');
const express = require('express');
const config = require('config');
const cors = require('cors');


const users = require('./routes/users');
const login = require('./routes/login')
const car_details = require('./routes/car_details');
const location = require('./routes/location');
const booking_details = require('./routes/booking_details');
const billing_details = require('./routes/billing_details');

const PORT = config.get("port");

const app = express(); 
app.use(express.json());
app.use(cors());
app.use('/users', users);
app.use('/login',login);
app.use('/cars', car_details);
app.use('/location', location);
app.use('/booking_details', booking_details);
app.use('/billing_details', billing_details);


app.listen(PORT, () => {console.log(`Server started listening at PORT ${PORT}`)});