import { useState } from 'react';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import {useHistory} from 'react-router-dom'
function Login() 
{
    const [user, setuser] = useState({username: "", password: ""});
    const [message, setmessage] = useState("");

    const history = useHistory();

    const SetMessage = (msg)=>{
        setmessage(msg);
        setTimeout(() => {
            setmessage("");
        }, 5000);
    }
    const OnTextChange = (args)=>{
            var copyOfUser = {...user};
            copyOfUser[args.target.name] = args.target.value;
            setuser(copyOfUser);
    }
    const DoLogin = ()=>{
        //hard coded check for data like username & password
        //later on we will change this code to XHR call.

        var helper = new XMLHttpRequest();
        helper.onreadystatechange = ()=>{
            if(helper.readyState === 4 && helper.status === 200)
            {
                var result =JSON.parse(helper.responseText);
                debugger;

                if(result.count!==undefined && 
                    result.count > 0)
                    {
                        sessionStorage.setItem("isloggedin", "true");
                        sessionStorage.setItem("username", user.username);
                        sessionStorage.setItem("token", result.token);
                        history.push("/db");
                    }
                    else
                    {
                        SetMessage("User name / password is invalid.");
                        setuser({username: "", password: ""});
                    }
            }
        };
        helper.open("POST", "http://127.0.0.1:9898/login");

        helper.setRequestHeader("Content-Type","application/json");
        var userInStringFormat = JSON.stringify(user)
        helper.send(userInStringFormat);
    }

    return (  <>
                <table>
                    <tbody>
                        <tr>
                            <td>User Name</td>
                            <td>
                                <input type="text" value={user.username} name='username' onChange={OnTextChange}/>
                            </td>
                        </tr>

                         <tr>
                            <td>Password</td>
                            <td>
                                <input type="password" value={user.password} name='password'  onChange={OnTextChange}/>
                            </td>
                        </tr>

                         <tr>
                            <td>
                                <input type="button" value="Sign in"
                                 onClick={DoLogin} className='btn btn-primary'/>
                            </td>
                        </tr>

                    </tbody>
                </table>
                <div className='alert alert-warning'>
                    {message}
                </div>
              </>);
}

export default Login;<h1>Login Here</h1>