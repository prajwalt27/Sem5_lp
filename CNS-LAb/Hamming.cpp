// string input
// induce error
// correct position of error

#include <iostream>
#include <string>
#include <cmath>
using namespace std;

class Hamming
{
public:
    int pbit;
    int dbit;

    Hamming(int p, int d)
    {
        pbit = p;
        dbit = d;
    }

    // function  to calculate r value
    int r_val(string s);

    // to find parity bits
    int store_Pbit(char a[], int r, int k, string bstring);

    // to calculate parity
    int parity(char p[], int pbits[],int k,int r);

    // function to take input value
    int input();
};

int Hamming ::r_val(string s)
{
    int m = s.size();
    int r;
    for (int i = 1; i <= m; i++)
    {
        if (m <= pow(2, i) - i - 1)
        {
            r = i;
            break;
        }
    }
    return r;
}

int Hamming::store_Pbit(char a[], int r, int k, string bstring)
{
    int pbits[r];
    for (int i = 0; i < r; i++)
    {
        pbits[i] == pow(2, i);
    }

    // storing pbits as x right to left
    for (int i = k; i <= 1; i--)
    {
        a[pbits[i]] = 'x';
    }

    // stroring dbits from left to right
    for (int i = 1; i <= k; i++)
    {
        if (a[i] != 'x')
        {
            a[i] = bstring[i];
        }
    }

    int p = parity(a, pbits,k,r);
}

int Hamming::parity(char p[], int pbits[],int k,int r)
{
    string pstring="";
    
}

int Hamming::input()
{
    string bstring;
    cout << "Enter Binary string: "
         << "\n";
    cin >> bstring;
    int k = bstring.size();
    int r = r_val(bstring);

    // final array with both bits
    int n = r + k;
    char farr[n];

    // to store pbits
    store_Pbit(farr, r, r + k, bstring);
}

int main()
{
    // string s;
    // cin >> s;
    // cout << r_val(s) << "\n";

    return 0;
}
