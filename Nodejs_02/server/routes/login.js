const mysql = require('mysql');
const express = require('express');
const app =  express.Router();
const atob = require('atob');
const config = require('config');

//This is for POST /login
app.post("/",(req, res)=>
{
     //GET Username & Password from req.body
    console.log("data receieved is " + req.body.email + req.body.password);
   
    //Compare credentials with DB
    var connectionDetails = {
                                host: config.get("server"),
                                database: config.get("database"),
                                user: config.get("user"),
                                password: config.get("password")
                            }
    var connection = mysql.createConnection(connectionDetails);
    var statement = `select count(*) as count from login where
                     username='${req.body.email}' and 
                     password='${req.body.password}'`;


    connection.query(statement, (error, result)=>{
        if(error==null)
        {
            console.log("Count Received from DB as " + result[0].count);
         
            //Generate Token
            var token = Math.floor(Math.random() * 10000);

            //Save Token In DB
            var connection2 = mysql.createConnection(connectionDetails);
            var statement2 = `update login set token = '${token}'
                              where username='${req.body.username}'`;
                
            connection2.query(statement2, (error2, result2)=>{
                if(error2==null)
                {
                    if(result2.affectedRows != undefined && 
                        result2.affectedRows > 0)
                        {
                            var reply = {count : result[0].count, 
                                         token : token};
                            res.setHeader("Content-Type", 
                                          "application/json");
                            res.write(JSON.stringify(reply));
                            connection2.end();
                            connection.end();
                            res.end();
                        }
                }
                else
                {
                    res.setHeader("Content-Type", "application/json");
                    res.write(JSON.stringify(error2));
                    connection2.end();
                    res.end();
                }
            })

        }
        else
        {
            res.setHeader("Content-Type", "application/json");
            res.write(JSON.stringify(error));
            connection.end();
            res.end();
        }
    })

    
})
  
module.exports =app;