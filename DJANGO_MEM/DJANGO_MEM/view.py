from DJANGO_MEM.dao_mem import DaoMem
from django.shortcuts import render
from django.views.decorators.csrf import csrf_exempt
def mem_list(request):
    de = DaoMem()
    list = de.selectList()
    data = { 
        "list" : list 
    }
    return  render(request, 'mem_list.html', data)

def mem_add(request):
    return render(request, 'mem_add.html')

def mem_detail(request):
    de = DaoMem()
    e_id = de.selectOne(request.GET.get("m_id"))
    data = {
        "vo" : e_id
        }
    return render(request, 'mem_detail.html', data)

def mem_mod(request):
    de = DaoMem()
    vo = de.selectOne(request.GET.get("m_id"))
    data = {
        "vo" : vo
        }
    return render(request, 'mem_mod.html', data)

@csrf_exempt
def mem_mod_act(request):
    de = DaoMem()
    m_id = request.POST["m_id"]
    name = request.POST["m_name"]
    tel = request.POST["tel"]
    address = request.POST["address"]
    cnt = de.update(m_id, name, tel, address)
    
    return render(request, 'mem_mod_act.html', {"cnt" : cnt})

@csrf_exempt
def mem_add_act(request):
    e_id = request.POST["m_id"]
    name = request.POST["m_name"]
    tel = request.POST["tel"]
    address = request.POST["address"]
    
    de = DaoMem()
    cnt = de.insert(e_id, name, tel, address)
    
    return render(request, 'mem_add_act.html', {"cnt" : cnt})

@csrf_exempt
def mem_del_act(request):
    de = DaoMem()
    m_id = request.POST["m_id"]
    cnt = de.delete(m_id)
    return render(request, 'mem_del_act.html', {"cnt" : cnt})