const p_min_value = document.getElementById('p-min-value');
const p_max_value = document.getElementById('p-max-value');
const e_min_value = document.getElementById('e-min-value');

const min_num = document.getElementById('min-num');
const max_num = document.getElementById('max-num');

p_min_value.addEventListener('input', (event) => {
    let current_field = document.getElementById('p-min');
    let max_value = parseInt(p_max_value.value);
    if (parseInt(p_min_value.value) >= max_value - 1){
        p_min_value.value = max_value - 1;
    }
    current_field.textContent = `min (${event.target.value})`;
    min_num.innerHTML = min_num.innerHTML.split('(')[0] + `(${(Math.pow(2, event.target.value - 1) + 1)}):`;
});

p_max_value.addEventListener('input', (event) => {
    let current_field = document.getElementById('p-max');
    let min_value = parseInt(p_min_value.value);
    if (parseInt(p_max_value.value) <= min_value + 1){
        p_max_value.value = min_value + 1;
    }
    current_field.textContent = `max (${event.target.value})`;
    max_num.innerHTML = max_num.innerHTML.split('(')[0] + `(${(Math.pow(2, event.target.value - 1) + 1)}):`;
});

e_min_value.addEventListener('input', (event) => {
    let current_field = document.getElementById('e-min');
    current_field.textContent = `Нижняя граница e (${event.target.value})`;
});