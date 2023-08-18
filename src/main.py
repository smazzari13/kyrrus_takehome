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

    header_not_found = True
    for i in range(0, len(headers)):
        if headers[i] == header_name:
            header_not_found = False
            column_number = i
            break

    if header_not_found:
        raise Exception("The header that was passed in cannot be found in the CSV headers")

    # Read and sort rows
    values = []
    for row in range(1, len(lines)):
        value = lines[row].strip().split(',')
        if len(value) != len(headers):
            raise Exception("The number of values in row " + str(row) + " do not match the number of headers")
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