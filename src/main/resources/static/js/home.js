const addListModal = document.getElementById('add-list-modal');
const selectListModal = document.getElementById('select-list-modal');
const addListMItemModal = document.getElementById('add-list-item-modal');
const listSelect = document.getElementById('list-select');

document.addEventListener('click', handleCloseModal);

function handleCloseModal(event) {
  if ((event.target.classList.contains('modal-close') || event.target.classList.contains('close-modal-btn'))) {
    event.preventDefault();
    addListModal.classList.remove('is-active');
    selectListModal.classList.remove('is-active');
    addListMItemModal.classList.remove('is-active');
  }
}

const confirmSelectListButton = document.getElementById('confirm-select-list-btn');
confirmSelectListButton.addEventListener('click', handleConfirmSelectListButton);

function handleConfirmSelectListButton(event) {
  window.location.replace(`/${listSelect.value}`);
}


const addListItemButton = document.getElementById('add-list-item-btn');
addListItemButton.addEventListener('click', handleAddListItemButton);

function handleAddListItemButton() {
  if (!addListMItemModal.classList.contains('is-active')) {
    addListMItemModal.classList.add('is-active');
  }
}
