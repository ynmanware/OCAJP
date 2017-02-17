// Code goes here

console.log(solution(-4, 1, 2, 6, 0, -1, 4, 3));

// you can write to stdout for debugging purposes, e.g.
// console.log('this is a debug message');

function solution(K, L, M, N, P, Q, R, S) {

	// calculate area of rectangle - 1
	var areaRect1 = getArea(K, L, M, N);
	console.log("a1: " + areaRect1);

	// calculate area of rectangle - 2
	var areaRect2 = getArea(P, Q, R, S);
	console.log("a2: " + areaRect2);

	// calculate area of intersection
	var x1 = Math.max(K, P);
	var x2 = Math.min(M, R);
	var y1 = Math.max(L, Q);
	var y2 = Math.min(N, S);

	var areaInt = getArea(x1, y1, x2, y2);
	console.log("aI: " + areaInt);

	var totalArea = areaRect1 + areaRect2 - areaInt;

	if (Number.isInteger(totalArea) && totalArea > -2147483648
			&& totalArea < 2147483647) {
		return totalArea;
	} else {
		return -1;
	}
}

function getArea(K, L, M, N) {
	var width = Math.abs(K - M);
	var height = Math.abs(L - N);
	return width * height;
}