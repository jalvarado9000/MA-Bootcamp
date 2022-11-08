// 1. Fix the code so that i declared in the if statement is a separate
// variable than i declared in the first line of the function. 
// Don't use the var keyword anywhere in your code
function checkScope() {
    var i = 'function scope';
    if (true) {
        i = 'block scope';
        log(1, `Block scope i is: ${i}`);
    }
    log(1, `Function scope i is: ${i}`);
    return i;
}
checkScope()


// 2. Change the array s to be [2, 5, 7] using various element assignments
const s = [5, 7, 2];
function editInPlace() {
    // Using s = [2, 5, 7] would be invalid

}
log(2, `${editInPlace()}`);


// 3. Rewrite the function assigned to the variable today 
// which returns a new Date() to use arrow function syntax. 
// Also, make sure nothing is defined using the keyword var
// Also, don't use the return keyword
var todayDate = function () {
    return new Date();
};

log(3, todayDate())


// 4. Rewrite the myConcat function which appends contents 
// of arr2 to arr1 so that the function uses arrow function syntax
// Don't use the var and return keyword
var myConcat = function (arr1, arr2) {
    return arr1.concat(arr2);
};
log(4, `${myConcat([1, 2], [3, 4, 5])}`);


// 5. Modify the function increment by adding default parameters
// so that it will add 1 to number if value is not specified
const increment = (number, value) => number + value;
log(5, increment(30))
log(5, increment(40, 10))


// 6. Use destructuring assignment to swap the values 
// of a and b. a should be equal to 6, and b to 8 
let a = 8, b = 6;

log(6, `a = ${a}, b = ${b}`)


// 7. Use destructuring assignment with the rest parameter so that 
// arr is a sub-array of the given array with the first two elements omitted
const original = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
function removeFirstTwo(array) {



    // return arr;
}
const arr = removeFirstTwo(original);
log(7, `arr = ${arr}`)


// 8. Use destructuring assignment to send only max and min inside the function
const results = {
    max: 56.78,
    median: 34.54,
    mode: 23.87,
    min: -0.75,
    average: 35.85
};

const half = (stats) => (stats.max + stats.min) / 2.0;
log(8, `half = ${half(results)}`)


// 9. Use object property shorthand with object literals
const createPerson = (name, age, gender) => {

    return {
        name: name,
        age: age,
        gender: gender
    };
};

log(9, `${JSON.stringify(createPerson("John Doe", 30, "M"))}`)

//10. Refactor the function setColor inside the object car to use the shorthand syntax

const car = {
    color: "Blue",
    setColor: function (newColor) {
        this.color = newColor;
    }
};
// car.setColor("Brown");
log(10, car.color);

//11. Use the class keyword and write a constructor to create the Drink class


const drink = new Drink('strawberry');
log(11, drink.name); // Should display 'strawberry'

//12. Modify the function sum using the rest parameter.
// This way the function sum will be able to take any number of arguments and return their sum.
const sum = (x, y, z) => {
    const args = [x, y, z];
    return args.reduce((a, b) => a + b, 0);
}

log(12, sum(1, 2, 3, 4, 5, 6, 7, 8, 11, 22));

//13. Copy all contents of arr1 into array arr2 using the spread operator
const arr1 = ['JAN', 'FEB', 'MAR', 'APR', 'MAY'];
// let arr2;

// arr2 = 

// log(13, arr2);

//14. Replace the two assignments with an equivalent destructuring assignment
const TEMPERATURES = {
    yesterday: 75,
    today: 77,
    tomorrow: 80
};

const today = TEMPERATURES.today;
const tomorrow = TEMPERATURES.tomorrow;

log(14, `today = ${today} tomorrow = ${tomorrow}`)

