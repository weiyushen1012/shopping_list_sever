console.log('test');

const burgerButton = document.getElementById('app-burger-button');
const navBarControl = document.getElementById('app-navbar-control');

function burgerButtonToggleHandler() {
  burgerButton.classList.toggle('is-active');
  navBarControl.classList.toggle('is-active');
}

burgerButton.addEventListener('click', burgerButtonToggleHandler);

