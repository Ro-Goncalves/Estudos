import { Form } from "@/components/Form";
import { redirect } from "next/navigation";


function LoginPage() {    
    async function loginAction(prevState: any, formData: FormData) {
        'use server';
        const response = await fetch("http://localhost:8000/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                username: formData.get('username'),
                password: formData.get('password'),
            }),
        });

        if(response.ok){
            const data = await response.json();
            redirect("/protected");
        }else{
            const data = await response.json();
            console.error(data);
        }
    }

    return (<div className="m-2">
        <div className="bg-white p-8 rounded shadow w-96">
            <h2 className="text-2xl mb-4 text-black">Login</h2>
            <Form action={loginAction}>
                <div>
                    <label className="block text-sm text-gray-00">Usuário</label>
                    <input type="text" name="username" className="w-full p-2 border rounded shadow mt-1 text-black" />
                </div>
                <div>
                    <label className="block text-sm text-gray-00">Senha</label>
                    <input type="password" name="password" className="w-full p-2 border rounded shadow mt-1 text-black" />
                </div>
                <div><button type="submit" className="bg-blue-500 text-white p2 rounded w-full mt-4">Entrar</button></div>
            </Form>
        </div>
    </div>)
}

export default LoginPage