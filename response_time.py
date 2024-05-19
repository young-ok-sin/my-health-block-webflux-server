import time
from flask import Flask, request, Response
import json
import requests

app = Flask(__name__)

def logResponseTime(method, usecase, path, body=None):
    headers = {'Content-Type': 'application/json; charset=utf-8'}
    ip = 'localhost'
    port = '8080'
    socket = f"{ip}:{port}"
    url = f"http://{socket}{path}"

    start_time = time.time()

    if method == 'POST':
        response = requests.post(url=url, headers=headers, json=body)
    elif method == 'GET':
        response = requests.get(url=url, headers=headers)

    end_time = time.time()

    # 반응 시간 계산 (밀리초 단위)
    response_time = (end_time - start_time) * 1000

    current_time = time.strftime("%Y-%m-%d %H:%M:%S", time.localtime())

    with open('./logs/response_time.log', 'a') as log_file:
        log_file.write(f"{current_time}, {ip:<15}, {usecase}, {response_time:.2f}ms\n")

    return response.json()

@app.route('/api/v1/patient/sign-up', methods=['POST'])
def patientSignUp():
    payload = request.json
    print(payload)

    path = '/api/v1/patient/sign-up'
    usecase = 'patientSignUp'
    result = logResponseTime('POST', usecase, path, payload)

    json_data = json.dumps(result)
    response = Response(json_data, content_type='application/json')
    return response

@app.route('/api/v1/doctor/sign-up', methods=['POST'])
def doctorSignUp():
    payload = request.json
    print(payload)

    path = '/api/v1/doctor/sign-up'
    usecase = 'doctorSignUp'
    result = logResponseTime('POST', usecase, path, payload)

    json_data = json.dumps(result)
    response = Response(json_data, content_type='application/json')
    return response

@app.route('/api/v1/sign-in', methods=['POST'])
def userSignIn():
    payload = request.json
    print(payload)

    path = '/api/v1/sign-in'
    usecase = 'userSignIn'
    result = logResponseTime('POST', usecase, path, payload)

    json_data = json.dumps(result)
    response = Response(json_data, content_type='application/json')
    return response

@app.route('/api/v1/question/enroll', methods=['POST'])
def enrollQuestion():
    payload = request.json
    print(payload)

    path = '/api/v1/question/enroll'
    usecase = 'enrollQuestion'
    result = logResponseTime('POST', usecase, path, payload)

    json_data = json.dumps(result)
    response = Response(json_data, content_type='application/json')
    return response

@app.route('/api/v1/question', methods=['GET'])
def getQuestion():
    path = '/api/v1/question'
    usecase = 'getQuestion'
    result = logResponseTime('GET', usecase, path)
    json_data = json.dumps(result)
    response = Response(json_data, content_type='application/json')
    return response

@app.route('/api/v1/opinion/enroll', methods=['POST'])
def enrollOpinion():
    payload = request.json
    print(payload)

    path = '/api/v1/opinion/enroll'
    usecase = 'enrollOpinion'
    result = logResponseTime('POST', usecase, path, payload)

    json_data = json.dumps(result)
    response = Response(json_data, content_type='application/json')
    return response

@app.route('/api/v1/patient/enroll-urgent-data', methods=['POST'])
def enrollUrgentData():
    payload = request.json
    print(payload)

    path = '/api/v1/patient/enroll-urgent-data'
    usecase = 'enrollUrgentData'
    result = logResponseTime('POST', usecase, path, payload)

    json_data = json.dumps(result)
    response = Response(json_data, content_type='application/json')
    return response

@app.route('/api/v1/doctor/get-patient-urgent-data', methods=['POST'])
def getPatientUrgentData():
    payload = request.json
    print(payload)

    path = '/api/v1/doctor/get-patient-urgent-data'
    usecase = 'getPatientUrgentData'
    result = logResponseTime('POST', usecase, path, payload)

    json_data = json.dumps(result)
    response = Response(json_data, content_type='application/json')
    return response

@app.route('/api/v1/patient/get-my-urgent-data', methods=['POST'])
def getMyUrgentData():
    payload = request.json
    print(payload)

    path = '/api/v1/patient/get-my-urgent-data'
    usecase = 'getMyUrgentData'
    result = logResponseTime('POST', usecase, path, payload)

    json_data = json.dumps(result)
    response = Response(json_data, content_type='application/json')
    return response

if __name__ == '__main__':
    app.run(port=5000, debug=True)
