#include <stdio.h>
#include <stdlib.h>


int main(int argc, char *argv[]) {
	char status = 'Y', letter;
	int size;
	int height = 5;
	int counter;
	int i, j;
	printf("Welcome to the letter printer. \n");
	while(status == 'Y'){
		printf("Enter the size: ");
		scanf(" %d", &size);
		
		while(size < 5 || size % 2 == 0){
			printf("Invalid size. Enter the size again: ");
			scanf(" %d", &size);
		}
		
		printf("Enter the letter: ");
		scanf(" %c", &letter);
		
		while(letter != 'W' && letter != 'X' && letter != 'Y' && letter != 'Z'){
			printf("Invalid letter. Enter the letter again: ");
			scanf(" %c", &letter);
		}
		
		switch(letter){
			case 'X':;
				int isMiddlePut = 1;
			    counter = 1;
			    for (i = 0; i <= size; i++){
			    	for (j = 0; j <= size - 1; j++){
			    		if (i == size/2){
			    			if (j == size/2){
			    				printf("*");
			    				break;
							}
							else{
								printf(" ");
							}
						}
			    		else if (j == i || j == size - counter){
			    			printf("*");
						}
						else{
							printf(" ");
						}
					}
					counter++;
					printf("\n");
				}
				break;
			case 'Y':
				counter = 1; 
			    for (i = 0; i < size; i++) 
			    { 
			        for (j = 0; j <= size; j++) 
			        { 
			        	if (i > size / 2){
			        		if (j == size / 2){
			        			printf("*");
			        			break;
							}
							else {
								printf(" ");
							}
						}
			            else if (j == i 
			                || j == size - counter) 
			                printf("*"); 
			            else
			                printf(" "); 
			        } 
			        printf("\n"); 
			        if (i < size / 2) 
			            counter++; 
			    } 
				break;
			case 'W':;
				counter = 0;
			    for (i = 0; i < size; i++)  
			    { 
			        for (j = 0; j <= size*4; j++){
			        	if (i == 0){
			        		if (j == i || j == size*2 || j== size*4){
			        			printf("*");
							}
							else{
								printf(" ");
							}
						}
						else if (i == size - 1){
							if (j == size || j == size*3){
								printf("*");
							}
							else{
								printf(" ");
							}
						}
						else if (j == i || j == size*4 - counter
								|| j == size*2 - counter || j == size*2 + counter){
							printf("*");
						}
						else {
							printf(" ");
						}
					}
					counter++; 
			        printf("\n"); 
			    } 
				break;
			case 'Z':
				counter = size; 
			    for (i = 0; i <= size; i++)  
			    { 
			        for (j = 0; j < size; j++) 
			        { 
			            if (i == 0 || i == size
			                || j == counter) 
			                printf("*"); 
			            else
			                printf(" "); 
			        }
			        counter--; 
			        printf("\n"); 
			    }
				break;
		}
		
		printf("\nWould you like to continue? (Y or N): ");
		scanf(" %c", &status);
	}
	printf("Goodbye :)");
	return 0;
}
