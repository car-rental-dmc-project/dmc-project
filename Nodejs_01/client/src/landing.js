import { Link, Switch, Route } from "react-router-dom";
import Home from "./Home";
import About from "./About";
import Contact from "./Contact";
import Dashboard from "./Dashboard";
import NotFound from "./NotFound";

function Landing() {
    return (<>
                <h1>Header</h1>
                <hr></hr>
              
                <Link to="/">Home</Link> {" | "}
                <Link to="/about">About Us</Link> {" | "}
                <Link to="/contact">Contact us</Link> {" | "}
                <Link to="/db">View Dashboard</Link> {" | "}
                <hr></hr>
                <Switch>
                    <Route exact path="/" component={Home}/>
                    <Route exact path="/home" component={Home}/>
                    <Route exact path="/about" component={About}/>
                    <Route exact path="/contact" component={Contact}/>
                    <Route exact path="/db" component={Dashboard}/>
                    <Route exact path="*" component={NotFound}/>
                </Switch>
                <hr></hr>
                <h1>Footer</h1>
            </>);
}



export default Landing;