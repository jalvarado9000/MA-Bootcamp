import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import './infoStyles.css'

export default function Form() {
    
 
        return (

        <div>



        <header>
        <img src="/assets/images/te-pops.png" alt="logo"/>
        <h1>Tech Elevator Popsicles</h1>
        

        <nav>
            <ul>
            <li><Link to="/">HOME</Link></li>
          <li><a href="">STORE</a></li>
          <li><Link to="/form">CONTACT US</Link></li>
            </ul>
        </nav>
    </header>

    
        <section class="contact-us">
            <h2>Contact Us</h2>
            <form action="madeup.java" method="post">
                
            <div class = "FullName">
                <br/>
                <label for="name">Name:</label>
                <br/>
                <input type="text" id = "name" name="name"/>
            </div>

        
            <div>
            <br/>
            <label for="find-us">How did you hear of us?</label>
            <br/>
            <select name="find-us" id="find-us">
            <option value="popsicle">Popsicle Monthly</option>
            <option value="google">Google.com</option>
            <option value="youtube">Youtube.com</option>
            <option value="ticktock">TickTock</option>
            <option value="other">Other</option>
        </select>
            </div>

            <div>
                <br/>
                <label for="favorite-popsicle">What color is your favorite popsicle?</label>
                <br/>
                <input type="color" id = "favorite-popsicle" name="favorite-popsicle" value="#00afef"/>
            </div>
            <div>
                <br/>
                <label for="comments">Please let us know any comments you have:</label>
                <br/>
                <input type="text" id = "comments" name="comments" required/>
            </div>

            <div class="s">
                <br/>
                <input type="submit" id="sub"/>
            </div>

            </form>
        </section>
        
    
        <footer> © Tech Elevator 2020</footer>
            </div>
        );
    }

 

