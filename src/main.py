import sys

if __name__ == "__main__":
    if len(sys.argv) != 3:
        raise Exception("Must pass in filepath for CSV and column to sort with")

    # Read File
    csv_file = open(sys.argv[1], 'r')
    lines = csv_file.readlines()

    # Determine column to sort by
    header_name = sys.argv[2]
    headers = lines[0].split(',')
    column_number = 0
    for i in range(0, len(headers)):
        if headers[i] == header_name:
            column_number = i
            break

    # Read and sort rows
    values = []
    for row in range(1, len(lines)):
        values.append(lines[row].strip().split(','))
    values.sort(key=lambda x:x[column_number], reverse=True)

    # Print output
    print(lines[0].strip())
    for value in values:
        row = ""
        for i in range(len(value)):
            if i == len(value) - 1:
                row += value[i]
            else:
                row += value[i] + ","
        print(row)

# from flask import Flask
# app = Flask(kyrrus_takehom WebServer’)

# @app.route(’/’)
# def get_data():
#     return [1,2,3]