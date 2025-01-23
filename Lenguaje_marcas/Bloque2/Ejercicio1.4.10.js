showStars(5);

function showStars(rows) {
    let stars = "*";
    for (let i = 0; i < rows; i++){
        console.log(stars);
        stars = stars+"*";
    }
}