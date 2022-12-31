let allItemsIncomplete = true;
const pageTitle = 'My Shopping List';
const groceries = [
  { id: 1, name: 'Oatmeal', completed: false },
  { id: 2, name: 'Milk', completed: false },
  { id: 3, name: 'Banana', completed: false },
  { id: 4, name: 'Strawberries', completed: false },
  { id: 5, name: 'Lunch Meat', completed: false },
  { id: 6, name: 'Bread', completed: false },
  { id: 7, name: 'Grapes', completed: false },
  { id: 8, name: 'Steak', completed: false },
  { id: 9, name: 'Salad', completed: false },
  { id: 10, name: 'Tea', completed: false }
];

/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  const title = document.getElementById('title');
  title.innerText = pageTitle;
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  const ul = document.querySelector('ul');
  groceries.forEach((item) => {
    const li = document.createElement('li');
    li.innerText = item.name;
    const checkCircle = document.createElement('i');
    checkCircle.setAttribute('class', 'far fa-check-circle');
    li.appendChild(checkCircle);
    ul.appendChild(li);
  });
}


document.addEventListener("DOMContentLoaded", () => {

  setPageTitle();
  displayGroceries();
  
  const allComplete = document.getElementById('toggleAll');
  
  allComplete.addEventListener('click', () => {
  if (allItemsIncomplete) {
  groceries.forEach((item) => {
  item.classList.add('completed');
  item.querySelector('i').classList.add('completed');
  });
  allComplete.innerText = 'Mark All Incomplete'
  } else {
  groceries.forEach((item) => {
  item.classList.remove('completed');
  item.querySelector('i').classList.remove('completed');
  });
  allComplete.innerText = 'Mark All Complete'
  }
  allItemsIncomplete =!allItemsIncomplete
  
  });
  
  const groceries = document.querySelectorAll('li');
  
  groceries.forEach((item) => {
  item.addEventListener('click', () => {
  if (!item.classList.contains('completed')) {
  item.classList.add('completed');
  item.querySelector('i').classList.add('completed');
  }
  });
  
  item.addEventListener('dblclick', () => {
    if (item.classList.contains('completed')) {
      item.classList.remove('completed');
      item.querySelector('i').classList.remove('completed');
    }
  });
  }
  )
  })
