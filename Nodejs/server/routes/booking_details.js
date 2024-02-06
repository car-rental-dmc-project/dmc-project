const config = require('config');
const mysql = require('mysql');
const express = require('express');
const app = express.Router();


<<<<<<< HEAD
=======

>>>>>>> 3ca799fa8c480386b47c4dc81caa535019936259
const connectionDetails = {
                            host : config.get("server"),
                            database : config.get("database"),
                            user : config.get("user"),
                            password : config.get("password")
                            }

<<<<<<< HEAD
app.get('/', (request, response) => {
    var statement = `select * from booking_details`;
    var connection = mysql.createConnection(connectionDetails);
                            
    connection.query(statement, (error, result) => {
        if(error==null)
            {
                connection.end(); 
                response.send(result);
            }
        else
            {
                connection.end();
                response.send(error);
            }
        });
    });


app.post('/', (request, response) => {

    var from_datetime = request.body.from_datetime;
    var to_datetime = request.body.to_datetime;
    var amount_per_hour = request.body.amount_per_hour;
    var status = request.body.status;
    var discount = request.body.discount;
    var deposit = request.body.deposit;
    var car_id = request.body.car_id;
    var pickup_drop = request.body.pickup_drop;

    var statement = `Insert into booking_details(from_datetime, to_datetime, amount_per_hour, status, discount, deposit, car_id, pickup_drop) 
                        values('${from_datetime}','${to_datetime}','${amount_per_hour}','${status}','${discount}','${deposit}', '${car_id}', '${pickup_drop}')`;

    var connection = mysql.createConnection(connectionDetails);

    connection.query(statement, (error, result) => {
        if(error==null)
        {
=======

// join query to used to display location of car and customer
// using car_id in booking_details and location_id in car_details
app.get('/',(request, response) => {
    var car_id = request.body.car_id;
    var statement = `select * from booking_details where car_id = ${car_id}`;
    var connection = mysql.createConnection(connectionDetails);
    connection.query(statement,(error,result)=>{
        if(error==null){
>>>>>>> 3ca799fa8c480386b47c4dc81caa535019936259
            connection.end(); 
            response.send(result);
        }
        else
        {
            connection.end();
            response.send(error);
        }
    });
});

app.delete('/:booking_id', (request, response) => {

<<<<<<< HEAD
    var location_id = request.params.location_id;
=======
    var booking_id = request.params.booking_id;
>>>>>>> 3ca799fa8c480386b47c4dc81caa535019936259

    var statement = `delete from booking_details where booking_id=${booking_id}`;

    var connection = mysql.createConnection(connectionDetails);

    connection.query(statement, (error, result) => {
        if(error==null)
        {
            connection.end(); 
            response.send(result);
        }
        else
        {
            connection.end();
            response.send(error);
        }
    });
});

<<<<<<< HEAD
app.put('/:booking_id', (request, response) => {

    var from_datetime = request.body.from_datetime;
    var to_datetime = request.body.to_datetime;
    var pickup_drop = request.body.pickup_drop;
    
    var statement = `update location set 
                     street = '${street}',
                     landmark = '${landmark}',  
                     city = '${city}', 
                     state = '${state}', 
                     zip_code = '${zip_code}', 
                     user_id = '${user_id}'
                     WHERE location_id = ${request.params.location_id}`;
=======
app.post('/', (request, response) => {

    var from = request.body.from_datetime;
    var to = request.body.to_datetime;
    var amount_per_hour = request.body.amount_per_hour;
    var status = request.body.status;
    var discount = request.body.discount;
    var deposit = request.body.deposit;
    var car_id = request.body.car_id;

    var statement = `insert into booking_details(from_datetime,to_datetime,amount_per_hour,status,discount,deposit,car_id) values('${from}','${to}',${amount_per_hour},${status},${discount},${deposit},${car_id})`;

>>>>>>> 3ca799fa8c480386b47c4dc81caa535019936259
    var connection = mysql.createConnection(connectionDetails);

    connection.query(statement, (error, result) => {
        if(error==null)
        {
            connection.end(); 
            response.send(result);
        }
        else
        {
            connection.end();
            response.send(error);
        }
    });
});
<<<<<<< HEAD

module.exports = app;
=======
>>>>>>> 3ca799fa8c480386b47c4dc81caa535019936259
