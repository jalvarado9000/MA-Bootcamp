// 1. Create a function called Hello (every component name should start with an uppercase). This function should return an h1 with the Hello greeting. Then, use this component three times in the App component. Since we need to have a single top-level component in JSX, wrap them with a div tag.

// function Hello() {}
// function App() {}


/* 2. Now, let's modify the Hello component to be more flexible. Let's add an argument in the Hello function or component called "props" (it is usually called this way). Now we can use the Hello component like this:
    <Hello name="Harry" />
Inside the Hello component, we can reference the provided value like this
    <AComponent>{props.name}</AComponent>

Modify the Hello and App components to print in the browser 

<div>
    <h1>Hello, John!</h1>
    <h1>Hello, Jane!</h1>
    <h1>Hello, everyone!</h1>
</div>

*/

// function Hello() {}
// function App() {}


/* 3. Finally, we can mix JSX and JavaScript
Create an array called names and add John, Jane and "everyone" to it. We can create Hello components on the fly based on how large the array is. For this, create a greetings array, it will be the result of iterating over the names array. On each iteration, return a Hello instance with the current name. The result should be the same as before.
*/




ReactDOM.render(<App />, document.getElementById("app"));
