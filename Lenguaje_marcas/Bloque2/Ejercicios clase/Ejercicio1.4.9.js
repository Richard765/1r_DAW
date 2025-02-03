const marks = [80, 80, 50];

console.log(calculateGrade(marks));

function calculateAverage(marks) {
    let sum = 0;
    for (let mark of marks) {
        sum += mark;
    }
    return sum / marks.length; 
}

function calculateGrade(marks) {
    const average = calculateAverage(marks);

    if (average >= 90) return "A";
    if (average >= 80) return "B";
    if (average >= 70) return "C";
    if (average >= 60) return "D";
    if (average <= 59) return "F";   
}
