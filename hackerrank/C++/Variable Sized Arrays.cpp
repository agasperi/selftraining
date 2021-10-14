int main() {
    long n = 0;
    long q = 0;
    long k = 0;
    long i = 0;
    long j = 0;

    cin >> n;
    cin >> q;

    long** arrayArrays = new long*[n];
    for(long l = 0; l < n; l++){
        cin >> k;
        arrayArrays[l] = new long[k];
        
        for(long m = 0; m < k; m++){
            cin >> arrayArrays[l][m];
        }
        
    }

    for(long l = 0; l < q; l++){
        cin >> i;
        cin >> j;
        cout << arrayArrays[i][j] << endl;
    }
    
	return 0;
}
