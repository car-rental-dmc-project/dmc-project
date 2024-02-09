import React from 'react';
import ReactDOM from 'react-dom/client';
// import Users from './Users';
// import Dashboard from './Dashboard';
import Landing from './Landing';
// import Print from './Print';
// import Container from './Container';
// import Parent from './Parent';
import {BrowserRouter} from 'react-router-dom';

const root = ReactDOM.createRoot(document.getElementById('root'));
// root.render(<Emp/>);
// root.render(<Users/>)
// root.render(<Dashboard/>)
// root.render(<Print/>)
// root.render(<Container/>)
// root.render(<Parent/>)

root.render(<BrowserRouter>
                <Landing/>
            </BrowserRouter>)