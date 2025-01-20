// scripts.js
document.addEventListener('DOMContentLoaded', function() {
    const bar = document.querySelector('.bar');
    const content = document.querySelector('.content');
    const menuButton = document.createElement('button');

    // Добавляем класс для кнопки меню
    menuButton.className = 'menu-button';

    // Начальный текст кнопки
    menuButton.textContent = 'Меню';

    menuButton.style.position = 'fixed';
    menuButton.style.top = '10px';
    menuButton.style.left = '10px';
    menuButton.style.backgroundColor = '#4CAF50';
    menuButton.style.color = 'white';
    menuButton.style.border = 'none';
    menuButton.style.padding = '10px';
    menuButton.style.cursor = 'pointer';
    menuButton.style.zIndex = 1000;

    menuButton.addEventListener('click', function() {
        bar.classList.toggle('open');
        content.classList.toggle('shifted');

        // Изменяем текст кнопки
        if (menuButton.textContent === 'Меню') {
            menuButton.textContent = 'X';
        } else {
            menuButton.textContent = 'Меню';
        }
    });

    document.body.insertBefore(menuButton, document.body.firstChild);
});
