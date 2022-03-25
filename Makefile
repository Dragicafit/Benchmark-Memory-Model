all: thread-test thread-test-atomic thread-test-lock thread-test-volatile

thread-test: thread-test.o
	g++ -g -o thread-test thread-test.o -pthread

thread-test-atomic: thread-test-atomic.o
	g++ -g -o thread-test-atomic thread-test-atomic.o -pthread

thread-test-lock: thread-test-lock.o
	g++ -g -o thread-test-lock thread-test-lock.o -pthread

thread-test-volatile: thread-test-volatile.o
	g++ -g -o thread-test-volatile thread-test-volatile.o -pthread

thread-test.o: thread-test.cc
	g++ -g -c -pthread -I/sw/include/root thread-test.cc

thread-test-atomic.o: thread-test-atomic.cc
	g++ -g -c -pthread -I/sw/include/root thread-test-atomic.cc

thread-test-lock.o: thread-test-lock.cc
	g++ -g -c -pthread -I/sw/include/root thread-test-lock.cc

thread-test-volatile.o: thread-test-volatile.cc
	g++ -g -c -pthread -I/sw/include/root thread-test-volatile.cc

time-java:
	/usr/bin/time -f "%e" java ThreadTest.java;
	/usr/bin/time -f "%e" java ThreadTestVolatile.java;
	/usr/bin/time -f "%e" java ThreadTestSynchronized.java;
	/usr/bin/time -f "%e" java ThreadTestLock.java;
	/usr/bin/time -f "%e" java ThreadTestAtomic.java;

time-c++: all
	/usr/bin/time -f "%e" ./thread-test;
	/usr/bin/time -f "%e" ./thread-test-volatile;
	/usr/bin/time -f "%e" ./thread-test-lock;
	/usr/bin/time -f "%e" ./thread-test-atomic;

time: time-java time-c++
