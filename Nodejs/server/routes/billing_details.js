const config = require('config');
const mysql = require('mysql');
const express = require('express');
const app = express.Router();


const connectionDetails = {
                            host : config.get("server"),
                            database : config.get("database"),
                            user : config.get("user"),
                            password : config.get("password")
                          }


app.get('/', (request, response) => {
    var statement = `select * from billing_details`;
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

    var booking_id = request.body.booking_id;
    var bill_date = request.body.bill_date;
    var bill_status = request.body.bill_status;
    var total_late_fees = request.body.total_late_fees;
    var total_amount = request.body.total_amount;

    var statement = `Insert into billing_details(booking_id, bill_date, bill_status, total_late_fees, total_amount) 
                        values('${booking_id}','${bill_date}','${bill_status}','${total_late_fees}','${total_amount}')`;

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


app.delete('/:bill_id', (request, response) => {

    var bill_id = request.params.bill_id;

    var statement = `delete from booking_details where booking_id=${bill_id}`;

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


//app.put

    
module.exports = app;
