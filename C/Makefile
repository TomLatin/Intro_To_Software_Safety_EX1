#!make -f

all: normalBounds.out normalAddress.out normalLeak.out normalIntegerDivideByZero.out bounds.out leak.out address.out integerDivideByZero.out

normalBounds.out: bounds.c
	gcc bounds.c -o normalBounds.out

normalAddress.out: address.c
	gcc address.c -o normalAddress.out

normalLeak.out: leak.c
	gcc leak.c -o normalLeak.out

normalIntegerDivideByZero.out: integerDivideByZero.c
	gcc integerDivideByZero.c -o normalIntegerDivideByZero.out

bounds.out: bounds.c
	gcc -fsanitize=bounds bounds.c -o bounds.out

address.out: address.c
	gcc -fsanitize=address address.c -o address.out

leak.out: leak.c
	gcc -fsanitize=leak leak.c -o leak.out

integerDivideByZero.out: integerDivideByZero.c
	gcc -fsanitize=integer-divide-by-zero integerDivideByZero.c -o integerDivideByZero.out


clean:
	rm -f *.out