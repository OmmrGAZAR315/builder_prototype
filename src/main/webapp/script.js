function fetchCarsData() {
    fetch('carServlet')
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            const carTableBody = document.getElementById('carTableBody');
            carTableBody.innerHTML = ''; // Clear previous table data
            data.forEach(car => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${car.ownerName}</td>
                    <td>${car.model}</td>
                    <td>${car.color}</td>
                    <td>${car.engine}</td>
                    <td>${car.fuelType}</td>
                    <td><button class="cloneButton" data-car='${JSON.stringify(car)}'>Clone</button></td>
                `;
                carTableBody.appendChild(row);
            });
        })
        .catch(error => {
            console.error('Error fetching cars data:', error);
        });
}

// Event delegation for clone buttons
document.addEventListener('click', function (event) {
    if (event.target.classList.contains('cloneButton')) {
        let carJson = event.target.dataset.car;
        fetch('cloneServlet', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: carJson
        })
            .then(response => response.text())
            .then(data => console.log(data)) // handle response from server
            .catch(error => console.error('Error:', error));
    }
});

// Call the function to fetch cars data when the page loads
window.onload = fetchCarsData;
