const p = document.getElementById('p_value');
const q = document.getElementById('q_value');
const e = document.getElementById('degree');


p.addEventListener('input', (event) => {
    const result = document.getElementById('p');
    result.textContent = `Минимальная битовая длина (2^(n-1)+1) для числа p [${event.target.value}]`;
});

q.addEventListener('input', (event) => {
    const result = document.getElementById('q');
    result.textContent = `Минимальная битовая длина (2^(n-1)+1) для числа q [${event.target.value}]`;
});

e.addEventListener('input', (event) => {
    const result = document.getElementById('e');
    result.textContent = `Нижняя граница степени e [${event.target.value}]`;
});