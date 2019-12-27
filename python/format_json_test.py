# -*- coding:utf-8 -*-
import json
import time
import datetime

order_keys = ["_id", "userId", "orderDescription", "orderType", "allianceid", "sid", "amout", "orderStatus", "source",
              "openId", "createTime", "updateTime"]


def format_hotel_order():
    with open('hotel.json', 'r', encoding='UTF-8') as f:
        data = json.load(f)
        format_data = open("hotel_format.json", "w", encoding='UTF-8')
        for me in data:
            if (me["_id"] == None):
                continue
            message = {}
            message["_class"] = "com.vivo.internet.jovi.intellig.trip.dal.document.HotelOrder"
            for key in me.keys():
                message[underline_to_camel(key)] = me[key]
            if (message.get("happenTime")):
                message["timestamp"] = time.mktime(
                    time.strptime(message.pop("happenTime"), '%Y-%m-%d %H:%M:%S')) * 1000
            if (message.get("payTime")):
                message["bookingDate"] = message.pop("payTime")
            for key in message.keys():
                message[key] = datestr_to_date(message[key])
            format_data.write(json.dumps(message, ensure_ascii=False) + "\n")
        print(len(data))


def format_train_order():
    with open('train.json', 'r', encoding='UTF-8') as f:
        data = json.load(f)
        format_result_map = {}
        for me in data:
            tickets = []
            message = {}
            if (me["_id"] == None):
                continue
            for key in me.keys():
                message[underline_to_camel(key)] = me[key]
            format_message = {}
            for order_key in order_keys:
                if (order_key in message.keys()):
                    format_message[order_key] = message.pop(order_key)
            if (message.get("happenTime")):
                format_message["timestamp"] = time.mktime(
                    time.strptime(message.pop("happenTime"), '%Y-%m-%d %H:%M:%S')) * 1000
            if (message.get("payTime")):
                format_message["bookingDate"] = message.pop("payTime")
            for key in message.keys():
                message[key] = datestr_to_date(message[key])
            tickets.append(message)
            format_message["tickets"] = tickets
            format_message["_class"] = "com.vivo.internet.jovi.intellig.trip.dal.document.TrainTicketOrder"
            old = format_result_map.get(format_message["_id"])
            if (old):
                old["tickets"].append(message)
            else:
                format_result_map[format_message["_id"]] = format_message
        format_data = open("train_format.json", "w", encoding='UTF-8')
        for message in format_result_map.values():
            for key in message.keys():
                message[key] = datestr_to_date(message[key])
            format_data.write(json.dumps(message, ensure_ascii=False) + "\n")
        print(len(format_result_map))


def formate_mq_message():
    with open('message.json', 'r', encoding='UTF-8') as f:
        data = json.load(f)
        format_data = open("message_format.json", "w", encoding='UTF-8')
        for message in data:
            format_data.write(str(message).replace("'", "\"") + "\n")
        print(len(data))

def format_cp_code():
    with open('cp_code.json', 'r', encoding='UTF-8') as f:
        data = json.load(f)
        format_data = open("cp_code_format.json", "w", encoding='UTF-8')
        for me in data:
            # if (me["_id"] == None):
            #     continue
            message = {}
            message["_class"] = "com.vivo.internet.jovi.intellig.trip.dal.document.CpCode"
            for key in me.keys():
                message[underline_to_camel(key)] = me[key]
                format_message = {}
            for key in message.keys():
                message[key] = datestr_to_date(message[key])
            format_data.write(json.dumps(message, ensure_ascii=False) + "\n")
        print(len(data))

def underline_to_camel(underline_format):
    if (underline_format == "_id" or underline_format == "_class"):
        return underline_format
    camel_format = ''
    if isinstance(underline_format, str):
        _ss = underline_format.split('_')
        for i in range(0, len(_ss)):
            if (i == 0):
                camel_format += _ss[i]
            else:
                camel_format += _ss[i].capitalize()
    return camel_format


# 改成mongo识别的日期
def datestr_to_date(strdate):
    try:
        if ":" in strdate:
            time.strptime(strdate, "%Y-%m-%d %H:%M:%S")
            result = {}
            result["$date"] = strdate
            return result
    except:
        return strdate
    return strdate


#format_hotel_order()
format_cp_code()
