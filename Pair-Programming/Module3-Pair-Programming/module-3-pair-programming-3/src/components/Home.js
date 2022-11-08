import React from 'react';
import { Link } from 'react-router-dom';
import './styles.css'
export default function Home() {
     
    
        return (

          <React.Fragment>

            <div>


            <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="assets/styles.css" />
  </head>
              
      <header id="header" class="header">
      <img id="header-logo" src="assets/images/te-pops.png" alt="logo" />
      <h1 id="header-text">Tech Elevator Popsicles</h1>

      <nav id="nav-menu">
        <ul>
        <li><Link to="/">HOME</Link></li>
          <li><a href="">STORE</a></li>
          <li><Link to="/form">CONTACT US</Link></li>
        </ul>
      </nav>
    </header>

    <main>
      <section id="know" class="know">
        <img
          id="know-image"
          src="assets/images/popsicle-rainbow.jpg"
          alt="Image of 5 rainbow popsicles with fruit background"
        />
        <section id="know-text">
          <h2>Did you know?</h2>
          <ul>
            <li>
              The earliest known popsicle date as far back as 1872. Back then, a
              popsicle was called a <em>Hokey-Pokey</em>
            </li>
            <li>
              Popsicles are also known as freezer pops, ice lollies, and ice
              pops.
            </li>
            <li>
              The world's largest popsicle was made in 1997 and was 21 feet
              tall.
            </li>
            <li>
              Popsicles have become so popular that a popular arts and craft item
              is called a popsicle stick
            </li>
          </ul>
        </section>
      </section>

      <section id="race" class="race">
        <img
          id="race-image"
          src="assets/images/blue-pop.png"
          alt="Image blue popsicle"
        />
        <h2 id="race-header">Popsicle Race</h2>
        <p id="race-body">
          Don't forget to sign up for the race! Each attendee will receive their
          own box of popsicles when they reach the end.
        </p>
      </section>

      <section id="summer" class="summer">
        <h2 id="summer-header">Get refreshed this summer</h2>
        <p id="summer-body">
          Mark this very special occasion of the launch of Tech Elevator
          Popsicles by buying a gift from our stunning array of items, shipped
          directly from Cleveland.
        </p>
        <a href="#" class="store-button">STORE</a>
      </section>
    </main>

    <footer>© Tech Elevator 2020</footer>
            </div>

            </React.Fragment>
        );
    }

 
