CC=clang
UTILS_CFLAG = -I include/utils
CORE_CFLAG = -I include/core
CLI_CFLAG = -I include/cli
DEBUG=

ifndef DEBUG
	CLEANUP=rm *.o
endif

compile:
	make utils-target
	make core-target
	make cli-target
	make exe-target

utils-target:
	$(CC) $(DEBUG) $(UTILS_CFLAG) -c src/utils/*.c

core-target:
	$(CC) $(DEBUG) $(UTILS_CFLAG) $(CORE_CFLAG) -c src/core/*.c

cli-target:
	$(CC) $(DEBUG) $(UTILS_CFLAG) $(CORE_CFLAG) $(CLI_CFLAG) -c src/cli/*.c

exe-target:
	$(CC) $(DEBUG) $(UTILS_CFLAG) $(CORE_CFLAG) $(CLI_CFLAG) -c src/main.c
	$(CC) $(DEBUG) *.o -o main
	$(CLEANUP)


