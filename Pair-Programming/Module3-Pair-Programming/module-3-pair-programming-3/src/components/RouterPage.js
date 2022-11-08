import React from 'react'
import Home from './Home';
import Form from './Form';
import { BrowserRouter as Router,Switch, Route } from 'react-router-dom'

export default function RouterPage() {
    
        return (

            <div>
                <Router>
                    <Switch>
                        <Route path="/" exact component={Home}/>
                        <Route path="/form" component={Form}/>
                    </Switch>
                </Router>
            </div>


        )
    }


