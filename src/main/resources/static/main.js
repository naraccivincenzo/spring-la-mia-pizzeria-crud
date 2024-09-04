document.getElementById('searchForm').addEventListener('submit', function (event) {
    event.preventDefault();

    const input = document.getElementById('searchInput').value;

    const encodedInput = encodeURIComponent(input);

    window.location.href = '/pizzas/findByNameContains/' + encodedInput;
});