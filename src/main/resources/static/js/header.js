const navBarControl = document.getElementById('app-navbar-control');

const burgerButton = document.getElementById('app-burger-button');
burgerButton.addEventListener('click', burgerButtonToggleHandler);

function burgerButtonToggleHandler() {
  burgerButton.classList.toggle('is-active');
  navBarControl.classList.toggle('is-active');
}

const selectListButton = document.getElementById('select-list');
selectListButton.addEventListener('click', handleSelectListButtonClick);

function handleSelectListButtonClick() {
  if (!selectListModal.classList.contains('is-active')) {
    selectListModal.classList.add('is-active');
  }
}

const createNewListButton = document.getElementById('create-new-list');
createNewListButton.addEventListener('click', handleCreateNewListButtonClick);

function handleCreateNewListButtonClick() {
  if (!addListModal.classList.contains('is-active')) {
    addListModal.classList.add('is-active');
  }
}
