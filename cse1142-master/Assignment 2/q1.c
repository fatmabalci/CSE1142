#include <stdio.h>

void reverseN(int *number, int N);

int main(){
	int num, N;
	int i;
	
	scanf("%d %d", &num, &N);
	int *number = &num;
	
	int topLimit = 1;
	for (i = 1; i < N; i++){
		topLimit *= 10;
	}
	
	if (*number >= topLimit){
		reverseN(number, N);
		printf("%d", *number);
	}
	else{
		int len = 1;
		while (*number != 0){
			*number = *number / 10;
			len++;
		}
		printf("N must be less than %d!", len);
	}
	
	return 0;
}

void reverseN(int *number, int N){
	int reversedInteger = 0;
	int powerOfTen = 1;
	
	while (*number != 0)
	{
		if (N != 0){
			reversedInteger *= 10;
		    reversedInteger += *number%10;
		    *number = *number/10;
		    powerOfTen *= 10;
		    N--;
		}
		else{
			reversedInteger += *number%10 * powerOfTen;
			*number = *number/10;
		    powerOfTen *= 10;
		}
	}
	*number = reversedInteger;
}
