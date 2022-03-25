#include <iostream>
#include <thread>

using namespace std;

long i;

void foo()
{
    for (long j = 0; j < 100000000; j++)
    {
        i++;
    }
}

int main()
{
    thread th1 = thread(foo);
    thread th2(foo);
    thread th3(foo);

    th1.join();
    th2.join();
    th3.join();

    cout << i << endl;

    return 0;
}
