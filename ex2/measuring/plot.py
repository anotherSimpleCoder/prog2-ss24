import matplotlib.pyplot as plt
import pandas as pd
import sys
import subprocess
import os

FILENAME = 'test.txt'

def generate_test_file():
    if os.path.exists('test.txt'):
        os.remove('text.txt')

    length = int(sys.argv[1])
    word = ''
    file = open(FILENAME, 'w')

    for _ in range(1, length+1):
        word += 'a'
        file.write(word + '\n')

    file.close()

def measure():
    if os.path.exists('result.csv'):
        os.remove('result.csv')
    
    subprocess.run(['java', '-jar', './target/ex2-1.0-SNAPSHOT.jar', FILENAME], check=True)
    assert os.path.exists('result.csv')

def read():
    data = pd.read_csv('result.csv', header=None)
    data.columns = ['Word length', 'Type', 'Time']
    data = data.sort_values(by="Word length")
    data = data.drop_duplicates(subset=['Word length', 'Type'])
    return data

def plot(values: pd.DataFrame):
    x = values['Word length'].drop_duplicates().values.tolist()
    y1 = values.loc[values['Type'] == 'recursive']['Time'].values.tolist()    
    y2 = values.loc[values['Type'] == 'iterative']['Time'].values.tolist()

    print(y1)
    print(y2)

    fig, ax = plt.subplots()
    ax.plot(x, y1, label='iterative')
    ax.scatter(x, y2, color="red", label="recursive")

    ax.set_xlabel('Word length')
    ax.set_ylabel('TIme (nanoseconds)')
    ax.set_title('Palindrom')

    ax.legend()
    plt.show()
    


def main():
    generate_test_file()
    measure()
    data = read()
    plot(data)

if __name__ == '__main__':
    main()
