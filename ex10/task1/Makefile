lib-target:
	gcc -g -c src/*.c -I include

cli-target:
	gcc -g -c cli/src/*.c -I cli/include -I include

binary:
	make lib-target
	make cli-target
	gcc *.o -o main
	rm *.o