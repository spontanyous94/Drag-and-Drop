const dragItems = document.querySelectorAll('.drag-item');
const dropItems = document.querySelectorAll('.drop-item');
let draggedItem = null;

// Add dragstart and dragend event listeners
dragItems.forEach(item => {
  item.addEventListener('dragstart', () => {
    draggedItem = item;
    item.classList.add('dragging');
  });

  item.addEventListener('dragend', () => {
    draggedItem = null;
    item.classList.remove('dragging');
  });
});

// Add dragover and drop event listeners for drop targets
dropItems.forEach(item => {
  item.addEventListener('dragover', (e) => {
    e.preventDefault();
  });

  item.addEventListener('drop', () => {
    if (draggedItem && draggedItem.dataset.match === item.dataset.match) {
      item.textContent = draggedItem.textContent;
      draggedItem.remove();
      checkMatch();
    }
  });
});

// Check if all matches are done
function checkMatch() {
  const remainingItems = document.querySelectorAll('.drag-item');
  if (remainingItems.length === 0) {
    document.getElementById('result').textContent = 'All items matched!';
  }
}
