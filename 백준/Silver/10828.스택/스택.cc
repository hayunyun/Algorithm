#include <cstdio>
#include <algorithm>
#include <stack>
#include <cstring>
using namespace std;



int N;
stack<int> st;
char str[10];
int main(){
    scanf("%d",&N);
    for(int i=1;i<=N;i++){
        scanf("%s",str);
        if(!strcmp(str,"push")){
            int a;
            scanf("%d",&a);
            st.push(a);
        }else if(!strcmp(str,"pop")){
            if(st.size()==0){
                printf("-1\n");
                continue;
            }
            printf("%d\n",st.top());
            st.pop();
        }else if(!strcmp(str,"top")){
            if(st.size()==0){
                printf("-1\n");
                continue;
            }
            printf("%d\n",st.top());
        }else if(!strcmp(str,"empty")){
            printf("%d\n",st.empty()?1:0);
        }else if(!strcmp(str,"size")){
            printf("%d\n",st.size());
        }
    }
    return 0;
}
