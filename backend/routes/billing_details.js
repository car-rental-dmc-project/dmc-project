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

//to get all billing details                          
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


//to add billing details    
app.post('/', (request, response) => {

    var booking_id = request.body.booking_id;
    var bill_date = request.body.bill_date;
    var bill_status = request.body.bill_status;
    var total_late_fees = request.body.total_late_fees;
    var total_amount = request.body.total_amount;
    var discount_amount = request.body.discount_amount;
    var deposit = request.body.deposit;

    var statement = `Insert into billing_details(booking_id, bill_date, bill_status,discount_amount, total_late_fees, total_amount, deposit) 
                        values('${booking_id}','${bill_date}','${bill_status}','${discount_amount}','${total_late_fees}','${total_amount}','${deposit}')`;

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


//to delete billing detail
app.delete('/:bill_id', (request, response) => {

    var bill_id = request.params.bill_id;

    var statement = `delete from billing_details where bill_id=${bill_id}`;

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


    
module.exports = app;
